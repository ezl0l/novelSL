import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;

public class SL {

    public static class Response {
        protected Scene[] scenes;
        protected String path;

        public Response(Scene[] scenes) {
            this.scenes = scenes;
        }
    }

    public static abstract class Token {
        protected String name;

        public Token(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Scene extends Token {
        protected Action[] actions;

        public Scene(String name) {
            super(name);
        }

        public Scene(String name, Action[] actions) {
            super(name);
            this.actions = actions;
        }

        public Action[] getActions() {
            return actions;
        }

        @Override
        public String toString() {
            return "Scene{" +
                    "name='" + name + '\'' +
                    ", actions=" + Arrays.toString(actions) +
                    '}';
        }
    }

    static class Action extends Token {
        protected Command[] commands;

        public Action(String name) {
            super(name);
        }

        public void exec(Environment environment) throws UnknownCommandException, IOException {
            for (Command command :
                    commands) {
                command.exec(environment);
            }
        }

        public Action(String name, Command[] commands) {
            super(name);
            this.commands = commands;
        }

        public Command[] getCommands() {
            return commands;
        }

        @Override
        public String toString() {
            return "Action{" +
                    "name='" + name + '\'' +
                    ", commands=" + Arrays.toString(commands) +
                    '}';
        }
    }

    static class Command extends Token {
        protected String[] params;

        public Command(String name) {
            super(name);
        }

        public void exec(Environment environment) throws UnknownCommandException, IOException {
            Engine.execCommand(this, environment);
        }

        public Command(String name, String[] params) {
            super(name);
            this.params = params;
        }

        public String[] getParams() {
            return params;
        }

        @Override
        public String toString() {
            return "Command{" +
                    "name='" + name + '\'' +
                    ", params=" + Arrays.toString(params) +
                    '}';
        }
    }

    public static Engine parse(String data) {
        return new Engine().setResponse(new Gson().fromJson(data, Response.class));
    }
}
