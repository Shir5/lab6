package commands;


import util.OutputUtil;



public class History extends Command{


    public History() {
        super("history", " : вывести последние 15 команд (без их аргументов)");

    }

    @Override
    public void execute(String s) {

        if (historyManager.getHistory().isEmpty()) {
            OutputUtil.outputManager("");
        } else {
            if (historyManager.getHistory().size() < 15) {
                OutputUtil.outputManagerLiner(historyManager.getHistory().subList(0, historyManager.getHistory().size())
                        .toString().replaceAll(", ", "\n").replace("[","").replace("]",""));
            } else {
                OutputUtil.outputManagerLiner(historyManager.getHistory().subList(historyManager.getHistory().size()-15, historyManager.getHistory().size())
                        .toString().replaceAll(", ", "\n").replace("[","").replace("]",""));
            }
        }

    }
}
