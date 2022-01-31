public class Engine {
    protected SL.Response response;

    public Engine() {
    }

    public Engine(SL.Response response) {
        this.response = response;
    }

    public void init() {
        for (SL.Scene scene :
                response.scenes) {
            for (SL.Action action :
                    scene.actions) {
                if(action.name.equals("init")) {

                }
            }
        }
    }

    public Engine setResponse(SL.Response response) {
        this.response = response;
        return this;
    }
}