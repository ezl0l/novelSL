import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnknownCommandException, IOException {
        Engine engine = SL.parse("{\n" +
                "\t\"scenes\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"dungeon\",\n" +
                "\t\t\t\"actions\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"name\": \"init\",\n" +
                "\t\t\t\t\t\"commands\": [\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\"name\": \"load_image\",\n" +
                "\t\t\t\t\t\t\t\"params\": [\"background\", \"S:\\/marketplace\\/blog\\/source\\/logo.png\"]" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}");
        engine.init();

        System.out.println(Engine.images.get("background").length);
        System.out.println(Engine.audios);
    }
}
