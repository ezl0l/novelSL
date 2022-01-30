public class Main {
    public static void main(String[] args) {
        SL.Response response = SL.parse("{\n" +
                "\t\"scenes\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"dungeon\",\n" +
                "\t\t\t\"actions\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"name\": \"init\",\n" +
                "\t\t\t\t\t\"commands\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"name\": \"load_image\",\n" +
                "\t\t\t\t\t\t\t\"params\": [\"background\", \"/images/back.png\"]\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}");
    }
}
