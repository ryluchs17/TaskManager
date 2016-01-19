import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * TaskList contains a list of tasks and operations for that list.
 * @author Ryan Luchs
 * 
 */
public class TaskList {
	/*
	 * Data:
	 * 
	 * - list of tasks
	 */
	
	ArrayList<Task> taskList;
	
	/*
	 * Operations
	 * 
	 * - add tasks
	 * - remove tasks
	 * - search by description
	 * - get tasks by index
	 * - search by priority
	 * - search by due date
	 * - search by completion
	 * - search by category
	 * - sort by priority
	 * - sort by due date
	 * - sort by completion
	 * - sort by category
	 * - write list to disk
	 * - read list from disk
	 */
	
	/**
	 * Create a new TaskList from scratch
	 */
	public TaskList(){
		taskList = new ArrayList<Task>();
	}
	
	/**
	 * Create a new TaskLst from disk, reading from provided filename.
	 * @param filename String filename
	 */
	public TaskList(String filename) throws FileNotFoundException {
		readFile(filename);
	}
	
	/**
	 * Add the provided task.
	 * @param t
	 * @return true if add succeeded
	 */
	public boolean addTask( Task t) {
		return taskList.add(t);
	}

	/**
	 * Return task at index i. Throws exception if index is illegal.
	 * @param i index of task
	 * @return Task object at index.
	 */
	public Task getTask(int i) {
		return taskList.get(i);
	}
	
	/**
	 * Remove the specified task at index i. Throws exception if index is illegal.
	 * @param i index of task to remove
	 */
	public void removeTask(int i) {
		taskList.remove(i);
	}
	
	/**
	 * Searches for s specific task by description.
	 * @param d The task description to search for
	 * @return The reference to the task
	 */
	public Task searchByDescription(String d) {
		Task search = null;
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDescription().equals(d)) {
				search = taskList.get(i);
				break;
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified priority.
	 * @param p The task priority to search for
	 * @return A TaskList containing all of the tasks of the specified priority.
	 */
	public TaskList searchByPriority(short p) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getPriority() == p) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified due date.
	 * @param d The task due date to search for
	 * @return A TaskList containing all of the tasks of the specified due date
	 */
	public TaskList searchByDueDate(Date d) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getDueDate().equals(d)) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified completion value of true or false
	 * @param t The task to search for by completion
	 * @return A TaskList containing all of the tasks of the specified completion
	 */
	public TaskList searchByCompleted(boolean t) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getCompleted() == t) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Searches for every task with a specified category
	 * @param t The task category to search for
	 * @return A TaskList containing all of the tasks of the specified category
	 */
	public TaskList searchByCategory(short c) {
		TaskList search = new TaskList();
		for( int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getCategory() == c) {
				search.addTask(taskList.get(i));
			}
		}
		
		return search;
	}
	
	/**
	 * Read list of tasks from filename provided. Throws exception
	 * @param filename Filename to read
	 */
	private void readFile(String filename) throws FileNotFoundException {
		//assume that taskList is initialized
		taskList.clear(); // remove all old tasks

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		try {
			reader.close();
		} catch(IOException e) {
			System.out.print("Cannot close file: " + e.getMessage());
		}
	}
	
	/**
	 * @param filename Filename to write
	 */
	public void writeFile(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filename);
		for(int i = 0; i < taskList.size(); i++) {
			taskList.get(i).write(writer);
		}
		writer.close();
	}
	
	/**
	 * Prints TaskList to screen
	 */
	public void print() {
		for( int i = 0; i < taskList.size(); i++) {
			taskList.get(i).print();
		} 
	}
	
}
