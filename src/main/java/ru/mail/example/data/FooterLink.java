package ru.mail.example.data;

public enum FooterLink {
    Mailru("Mail.Ru"),
    Facebook("Мы в Facebook"),
    Policy("Условия использования материалов"),
    Mobile("Мобильная версия"),
    Advert("Реклама");



    private final String name;

    FooterLink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
