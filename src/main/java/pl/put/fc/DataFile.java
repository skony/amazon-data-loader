package pl.put.fc;

public enum DataFile {
    
    AMAZON_INSTANT_VIDEO("meta_Amazon_Instant_Video.json"),
    APPS_FOR_ANDROID("meta_Apps_for_Android.json"),
    AUTOMOTIVE("meta_Automotive.json"),
    BABY("meta_Baby.json"),
    BEAUTY("meta_Beauty.json"),
    BOOKS("meta_Books.json"),
    CDS_AND_VINYL("meta_CDs_and_Vinyl.json"),
    CELL_PHONES_AND_ACCESSORIES("meta_Cell_Phones_and_Accessories.json"),
    CLOTHING_SHOES_AND_JEWELRY("meta_Clothing_Shoes_and_Jewelry.json"),
    DIGITAL_MUSIC("meta_Digital_Music.json"),
    ELECTRONICS("meta_Electronics.json"),
    GROCERY_AND_GOURMET_FOOD("meta_Grocery_and_Gourmet_Food.json"),
    HEALTH_AND_PERSONAL_CARE("meta_Health_and_Personal_Care.json"),
    HOME_AND_KITCHEN("meta_Home_and_Kitchen.json"),
    KINDLE_STORE("meta_Kindle_Store.json"),
    MOVIES_AND_TV("meta_Movies_and_TV.json"),
    MUSICAL_INSTRUMENTS("meta_Musical_Instruments.json"),
    OFFICE_PRODUCTS("meta_Office_Products.json"),
    PATIO_LAWN_AND_GARDEN("meta_Patio_Lawn_and_Garden.json"),
    PET_SUPPLIES("meta_Pet_Supplies.json"),
    SPORTS_AND_OUTDOORS("meta_Sports_and_Outdoors.json"),
    TOOLS_AND_HOME_IMPOVEMENT("meta_Tools_and_Home_Improvement.json"),
    TOYS_AND_GAMES("meta_Toys_and_Games.json"),
    VIDEO_GAMES("meta_Video_Games.json");
    
    private final String originalMetaFile;
    
    private DataFile(String originalMetaFile) {
        this.originalMetaFile = originalMetaFile;
    }
    
    public String getOriginalMetaFile() {
        return originalMetaFile;
    }
    
    public String getFixedMetaFile() {
        return originalMetaFile.replace(".json", "_fixed.json");
    }
}
