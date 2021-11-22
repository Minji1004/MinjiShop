package minji.project.JpaPractice.web.dto;

public enum ItemType {

    ALBUM("A"),
    BOOK("B"),
    MOVIE("M");

    private final String itemTypeKey;

    ItemType(String itemTypeKey) {
        this.itemTypeKey = itemTypeKey;
    }

    public static ItemType fromString(String itemTypeKey) {
        for (ItemType i : ItemType.values()) {
            if (i.itemTypeKey.equalsIgnoreCase(itemTypeKey)) {
                return i;
            }
        }
        return  null;
    }
}
