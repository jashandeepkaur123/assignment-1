class Action {
    String type;
    String[] parameters;

    public Action(String type, String... parameters) {
        this.type = type;
        this.parameters = parameters;
    }
}

class Node {
    Action action;
    Node next;

    public Node(Action action) {
        this.action = action;
    }
}

class UndoRedoStack {
    private Node undoTop;
    private Node redoTop;

    public void addActionToUndoStack(Action action) {
        Node newNode = new Node(action);
        newNode.next = undoTop;
        undoTop = newNode;
    }

    public void undo() {
        if (undoTop != null) {
            Node undoAction = undoTop;
            undoTop = undoTop.next;

            undoAction.next = redoTop;
            redoTop = undoAction;
        }
    }

    public void redo() {
        if (redoTop != null) {
            Node redoAction = redoTop;
            redoTop = redoTop.next;

            redoAction.next = undoTop;
            undoTop = redoAction;
        }
    }

    public void printMostRecentAction() {
        if (undoTop != null) {
            System.out.println("Type: " + undoTop.action.type + ", Parameters: " + String.join(", ", undoTop.action.parameters));
        } else {
            System.out.println("Undo stack is empty.");
        }
    }
}

public class exercise_5 {
    public static void main(String[] args) {
        UndoRedoStack undoRedoStack = new UndoRedoStack();

        undoRedoStack.addActionToUndoStack(new Action("move", "circle", "50", "60"));
        undoRedoStack.addActionToUndoStack(new Action("resize", "triangle", "70", "80"));
        undoRedoStack.addActionToUndoStack(new Action("draw", "circle", "50", "60"));
        undoRedoStack.addActionToUndoStack(new Action("move","rectangle", "10", "20", "30", "40"));

        undoRedoStack.printMostRecentAction();

        undoRedoStack.undo();
        undoRedoStack.printMostRecentAction();

        undoRedoStack.redo();
        undoRedoStack.printMostRecentAction();
    }
}
