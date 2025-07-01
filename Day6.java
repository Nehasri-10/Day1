import java.awt.*;
import javax.swing.*;

public class Day6 extends JFrame {
    private JTextField taskField;
    private JButton addButton, deleteButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    public Day6() {
        setTitle("Task Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        taskField=new JTextField(20);
        addButton=new JButton("Add Task");
        deleteButton=new JButton("Delete Task");
        listModel=new DefaultListModel<>();
        taskList=new JList<>(listModel);
        JScrollPane scrollPane=new JScrollPane(taskList);
        JPanel inputPanel=new JPanel(new GridLayout(2, 1, 5, 5));
        inputPanel.add(taskField);
        JPanel buttonPanel=new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        inputPanel.add(buttonPanel);
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);       
        addButton.addActionListener(e -> {
            String task=taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });
        deleteButton.addActionListener(e -> {
            int selectedIndex=taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete.");
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Day6().setVisible(true));
    }
}
