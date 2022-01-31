import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Engine {
    protected SL.Response response;
    public static Map<String, byte[]> images = new HashMap<>();
    public static Map<String, byte[]> audios = new HashMap<>();

    public Engine() {
    }

    public Engine(SL.Response response) {
        this.response = response;
    }

    public static void execCommand(SL.Command command, Environment environment) throws UnknownCommandException,
            IOException {
        switch(command.name) {
            case "load_image": {
                System.out.println("[INFO] Loading image from " + environment.PATH + command.params[1] + "...");
                images.put(command.params[0], ((DataBufferByte) ImageIO.read(new File(environment.PATH + command.params[1]))
                        .getRaster()
                        .getDataBuffer())
                        .getData());
                break;
            }

            case "load_audio": {
                audios.put(command.params[0], ((DataBufferByte) ImageIO.read(new File(environment.PATH + command.params[1]))
                        .getRaster()
                        .getDataBuffer())
                        .getData());
                break;
            }

            case "if": {

                break;
            }

            default:
                throw new UnknownCommandException();
        }
    }

    public void init() throws UnknownCommandException, IOException {
        for (SL.Scene scene :
                response.scenes) {
            for (SL.Action action :
                    scene.actions) {
                if(action.name.equals("init")) {
                    System.out.println("[INFO] Exec '" + action.name + "' action...");
                    action.exec(new Environment(""));
                }
            }
        }
    }

    public Engine setResponse(SL.Response response) {
        this.response = response;
        return this;
    }
}