package collectionTreeSetTreeMap.part1.task7;

public class Convert {
    public static void main(String[] args) {
        ConvertToArabic convertToArabic = new ConvertToArabic();
        ConvertToRoman convertToRoman = new ConvertToRoman();
        ConvertToRoman1 convertToRoman1 = new ConvertToRoman1();

        convertToArabic.convertToArabic("CCCLXXIX");
        convertToRoman.convertToRoman(379);
        convertToRoman1.convertToRoman(379);

        System.out.println();

        convertToArabic.convertToArabic("CMLXXXIII");
        convertToRoman.convertToRoman(983);
        convertToRoman1.convertToRoman(983);



    }
}
