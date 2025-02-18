# Woche 1: Einführung & HTML


## Vorlesungsfolien

* [Einführung](01a%20Einführung.pdf)
* [History and rendering approaches](01b%20History%20and%20Rendering%20Approaches.pdf)
* [HTML](01c%20HTML.pdf)


## IDE, JDK, Git

Als IDE empfehle ich [IntelliJ Ultimate Edition](https://www.jetbrains.com/idea/download/), welches für Web-Technologien (HTML, CSS, JS), für Java und für weitere Technologien wie Spring, Datenbanken, etc. hervorragende Unterstützung bietet. Studierende können eine kostenlose Lizenz über das [JetBrains Studentenprogramm](https://www.jetbrains.com/community/education/#students) erhalten.

Als Programmiersprache für das Backend verwenden wir Java. Installiere also das JDK für die aktuelle LTS Java Version (im Moment 21).

Ausserdem solltest du eine aktuelle Version von Git installiert haben.


## Übungen

### 1. Brief strukturieren

*Diese Übung wurde von [Mozilla](https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML/Marking_up_a_letter) entwickelt.*

Die notwendigen Dateien findest du auch [hier](exercise-letter).

1) Erstelle eine HTML-Datei und füge den Text aus `letter-text.txt` ein.
2) Erstelle das HTML Grundgerüst und binde das CSS Stylesheet `style.css` ein (Du musst selber für diese Übung kein CSS schreiben). Du kannst die im Stylesheet definierte Klasse `sender-column` verwenden, um den Absender rechts auszurichten.
3) Strukturiere den Brief mit HTML gemäss [Vorlage](exercise-letter/letter.png). 
4) Verwende auch semantische HTML Elemente, um Screenreader zu unterstützen (z.B. das `<time>` Element).
5) Validiere dein HTML mit dem _Nu HTML Checker_: https://validator.w3.org/nu/.

[HTML-Referenz](https://developer.mozilla.org/en-US/docs/Web/HTML/Element)

### 2. Browser Dev Tools

1. Schaue dir den HTML Sourcecode und den DOM von ausgewählten Webseiten an.
2. Schaue auch, was im Netzwerk-Tab in den Dev Tools passiert, wenn du die Seite neu lädst oder auf der Seite navigierst.
3. Versuche herauszufinden, ob eine Seite Server Rendering oder Client Side Rendering verwendet, oder ob es eine Hybrid-Lösung ist.


## Übungen zur Festigung

### 3. Mini-Übungen von w3schools.com

Unter https://www.w3schools.com/html/exercise.asp findest du eine Reihe von kleinen Übungen, um die Grundlagen von HTML zu festigen.

### 4. HTML-Quiz

Hier kannst du dein Wissen in einem Quiz testen: https://www.w3schools.com/html/html_quiz.asp

Nutze falsche Antworten als Gelegenheit, diese Themen nochmals zu studieren.

Bei Bedarf findest du viele weitere HTML-Übungen und Quizze im Internet.


## Übungsideen für Neugierige

Aber vergesse deine anderen Vorlesungen nicht!

### 5. Eigene Website

Versuche ein HTML Dokument mit möglichst wenig Nachschauen von Grund auf zu schreiben. Als Vorlage kannst du eine beliebige Webseite nehmen (z.B. eine Wikipedia-Seite) oder du kannst selber etwas erfinden (vielleicht eine persönliche Webseite, falls du noch keine hast).

### 6. Screenreader

Probiere das Internet über einen Screenreader "blind" zu verwenden. Probiere auch aus, was für einen Einfluss semantische Elemente in der Brief-Übung auf die Screenreader-Ausgabe haben.

* _ChromeVox_ in Google Chrome
* _JAWS_ oder _NVDA_ auf Windows
* _VoiceOver_ wird mit MacOS geliefert

### 7. AI Chatbot

Zeichne ein Websiten-Layout oder ein Web-Formular auf ein Blatt Papier, mache davon ein Foto und instruiere den Chatbot deines Vertrauens, daraus HTML zu erzeugen.

* Studiere den erzeugten HTML-Code. Verstehst du alles?
* Entspricht der Code deinen Vorstellungen? Falls nicht, kannst du das Ergebnis mit einem besseren Prompt verbessern?
* Du kannst auch mehrere Chatbots miteinander vergleichen. Wo bekommst du die beste Ausgabe?
