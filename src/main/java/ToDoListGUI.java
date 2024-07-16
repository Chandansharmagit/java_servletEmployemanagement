import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListGUI {
    private JFrame frame;
    private JTextField taskField;
    private JButton addButton;
    private JButton removeButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoListGUI() {
        frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        taskField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        taskList = new JList<>();
        listModel = new DefaultListModel<>();

        taskList.setModel(listModel);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(taskField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(new JScrollPane(taskList));

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        addButton.addActionListener(new AddButtonListener());
        removeButton.addActionListener(new RemoveButtonListener());
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        }
    }

    private class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListGUI();
            }
        });
    }
}