package ch.fhnw.webec.contactlist.service;

import ch.fhnw.webec.contactlist.db.ContactRepository;
import ch.fhnw.webec.contactlist.model.Contact;
import ch.fhnw.webec.contactlist.model.ContactListEntry;
import ch.fhnw.webec.contactlist.model.ContactStatistics;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

@Service
public class ContactService {

	private ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public List<ContactListEntry> getContactList() {
		return contactRepository.findAll().stream()
				.sorted(comparing(Contact::getId))
				.map(c -> new ContactListEntry(c.getId(), c.getFirstName() + " " + c.getLastName()))
				.toList();
	}

	// TODO should be improved by filtering on DB level
	public List<ContactListEntry> searchContactList(String query) {
		return contactRepository.findAll().stream()
				.filter(c -> c.containsString(query))
				.sorted(comparing(Contact::getId))
				.map(c -> new ContactListEntry(c.getId(), c.getFirstName() + " " + c.getLastName()))
				.toList();
	}

	public ContactStatistics getContactStatistics() {
		var contacts = contactRepository.findAll();

		return new ContactStatistics(
			contacts.size(),
			contacts.stream().mapToInt(x -> x.getPhone().size()).sum(),
			contacts.stream().mapToInt(x -> x.getEmail().size()).sum()
		);
	}

	public Optional<Contact> findContact(int id) {
		return contactRepository.findById(id);
	}

	public Contact add(String firstName, String lastName, String jobTitle, String company) {
		var contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setJobTitle(jobTitle);
		contact.setCompany(company);
		return add(contact);
	}

	public Contact add(Contact contact) {
		contact.setId(0); // because we get generated IDs from @GeneratedValue
		contactRepository.save(contact);
		return contact; // important for later, when using Repository
	}

	public void update(Contact contact) {
		contactRepository.save(contact);
	}

	public void delete(int id) {
		contactRepository.deleteById(id);
	}
}
