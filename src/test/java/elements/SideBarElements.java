package elements;

public enum SideBarElements {

    OPEN_BURGER_BUTTON("//button[@id='react-burger-menu-btn']","id='react-burger-menu-btn'"),
    ALL_ITEM_BUTTON("//a[@id='inventory_sidebar_link']","id='inventory_sidebar_link'"),
    SIDE_BAR_MENU_WRAPPER("//div[@class='bm-menu-wrap']");



    public  String id;
    public final String xpath;




    SideBarElements(String xpath, String id){
        this.xpath = xpath;
        this.id = id;
    }

    SideBarElements(String xpath) {
        this.xpath = xpath;
    }


}
