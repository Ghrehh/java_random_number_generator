import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.Random;
 
// An AWT program inherits from the top-level container java.awt.Frame
public class RanNum extends Frame implements ActionListener {
   private Label lblRandom;    // Declare a Label component 
   private TextField tfRandom; // Declare a TextField component 
   
   private Label lblMin;
   private TextField tfMin;
   
   private Label lblMax;
   private TextField tfMax;
   
   private Button btnRandom;   // Declare a Button component
   
   private int randomMin = 1;
   private int randomMax = 100;
   private int randomNumber;;     // Counter's value
 
   // Constructor to setup GUI components and event handlers
   public RanNum () {
      setLayout(new FlowLayout());
         // "super" Frame (a Container) sets its layout to FlowLayout, which arranges
         // the components from left-to-right, and flow to next row from top-to-bottom.
      
      lblMin = new Label("Min Value");
      add(lblMin);
      
      tfMin = new TextField("1", 10);
      add(tfMin);
      tfMin.addActionListener(this);
      
      
      lblMax = new Label("Max Value");
      add(lblMax);
      
      tfMax = new TextField("100", 10);
      add(tfMax);
      tfMax.addActionListener(this);
      
 
      lblRandom = new Label("Random Number");  // construct the Label component
      add(lblRandom);                    // "super" Frame adds Label
 
      tfRandom = new TextField("0", 10); // construct the TextField component
      tfRandom.setEditable(false);       // set to read-only
      add(tfRandom);                     // "super" Frame adds TextField
 
      btnRandom = new Button("Generate");   // construct the Button component
      add(btnRandom);                    // "super" Frame adds Button
 
      btnRandom.addActionListener(this);
         // btnCount is the source object that fires ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //  an ActionEvent handler called actionPerformed().
         // Clicking btnCount invokes actionPerformed().
 
      setTitle("Random Number Generator");  // "super" Frame sets its title
      setSize(250, 165);        // "super" Frame sets its initial window size
 
      // For inspecting the components/container objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      setVisible(true);         // "super" Frame shows
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
   }
   
   private void generateRandomNumber(){
	  
	  int newMin, newMax;
	  try {
		  newMin = Integer.parseInt(tfMin.getText());
	  }
	  catch (NumberFormatException v) {
		  newMin = 0;
	  }
	  
	  try {
		  newMax = Integer.parseInt(tfMax.getText());
	  }
	  catch (NumberFormatException v) {
		  newMax = 100;
	  }
	  

	   
	  randomMin = newMin;
	  randomMax = newMax;
	   
	  Random random = new Random();
	  randomNumber = random.nextInt(randomMax - randomMin + 1) + randomMin;
	  // Display the counter value on the TextField tfCount
	  tfRandom.setText(randomNumber + ""); // convert int to String
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      new RanNum();
   }
 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
	  Object src = evt.getSource();
	 
	  if (src == btnRandom){
		  generateRandomNumber();
	  }
	  else if (src == tfMin){
		  int numberIn = Integer.parseInt(tfMin.getText());
		  randomMin = numberIn;
	  }
	  else if (src == tfMax) {
		  int numberIn = Integer.parseInt(tfMax.getText());
		  randomMax = numberIn;
	  }
	  
	  
   }
}