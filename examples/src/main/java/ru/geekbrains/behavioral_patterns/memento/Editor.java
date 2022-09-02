package ru.geekbrains.behavioral_patterns.memento;

public class Editor {

    private String content = "";

    public String type(String words) {
       return this.content = this.content + " " + words;
    }


    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
    }

}
