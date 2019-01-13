package apiFiles;

public class payLoad {

    public static String getPostData(){
        String b = "{\n" +
                "    \"location\": {\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\": \"Frontline house\",\n" +
                "    \"phone_number\": \"(+91)983 893 3937\",\n" +
                "    \"types\": [\n" +
                "        \"shoe park\",\n" +
                "        \"shop\"\n" +
                "    ],\n" +
                "    \"website\": \"http://goggle.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";
        return b;
    }

    public static String getXmlPostData(){

        String b = "<root>\n" +
                "\n" +
                "   <accuracy>50</accuracy>\n" +
                "\n" +
                "   <language>French-IN</language>\n" +
                "\n" +
                "   <location>\n" +
                "\n" +
                "      <lat>-38.383495</lat>\n" +
                "\n" +
                "      <lng>33.42736</lng>\n" +
                "\n" +
                "   </location>\n" +
                "\n" +
                "   <name>Frontline house</name>\n" +
                "\n" +
                "   <phone_number>(+91)983 893 3937</phone_number>\n" +
                "\n" +
                "   <types>\n" +
                "\n" +
                "      <element>shoe park</element>\n" +
                "\n" +
                "      <element>shop</element>\n" +
                "\n" +
                "   </types>\n" +
                "\n" +
                "   <website>http://goggle.com</website>\n" +
                "\n" +
                "</root>";
        return b;
    }
}
