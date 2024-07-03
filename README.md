Project Background
E-commerce has revolutionized retail, making shopping accessible anytime and anywhere. The HIVE project aims to offer a comprehensive online shopping experience built with Java to ensure robustness and scalability.

Purpose of the Report
This report documents the design, development, and implementation of the HIVE e-commerce system, detailing the project's objectives, architecture, features, and quality assurance steps.

Project Objectives

Primary Objectives

Develop a user-friendly e-commerce platform.
Implement a secure and efficient system for handling user data and transactions.
Provide administrative tools for managing products, orders, and user accounts.

Secondary Objectives
Ensure scalability for future growth.
Implement comprehensive testing for reliability and performance.
Facilitate easy maintenance and updates.


System Overview

Description
HIVE is a Java based e-commerce system designed for online shopping. Users can browse products and securely add them to a shopping cart and checkout. Administrators can manage product listings, view sales reports, and handle customer inquiries.

Scope
HIVE includes:
User registration and authentication.
Product catalog management.
Shopping cart functionality.
Order processing and payment integration.
Administrative dashboard.


Features and Functionalities

Buyer’s Features
Registration and Login:
Create an account and log in for personalized features.





Product Browsing:
Browse and search products.


Shopping Cart:
Add products to the cart, view and remove from cart.


Checkout Process: 
Secure and streamlined checkout with shipping and payment options.




Saler’s Features
Product Management:
Add, view and delete products.








Income Reports:
 Generate sales and income reports.

Administrative Features
User data Management:
 Edit or permanently delete a user.




User Management:
 Manage user accounts and permissions.




System Architecture

Overview
HIVE's architecture is modular and scalable, consisting of:
Presentation Layer:
 Handles the user interface and interactions.
Data Access Layer:
 Manages data storage and retrieval from the database.

Technology Stack
Programming Language: Java

Implementation Details

Development Environment
IDE:  NetBeans
Build Tool:  Apache Ant

Custom Library 
JCalendar : 
Used for Date selection, time chooser, day chooser.


Classes and Methods
Login Package:

Login_UI.java:
The code references two additional classes, Admin and User, which are instantiated when the respective login buttons are clicked. These classes are responsible for the functionality and interface of the Admin and User login panel.
Methods:
jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt): Handles the Admin login button click.
jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt): Handles the User login button click.
jLabel4MouseClicked(java.awt.event.MouseEvent evt): Handles the click event on the unauthorized admin access warning label.
Register.java:
This class mainly gets data from users and stores it. The class writes user data to a file upon successful registration. The writeUserData method of DataHandler class is called with parameters such as user type (buyer or seller), username, email, name, phone, and password.
This method is invoked after input validation and ensures that the data is stored persistently.

Admin.java:
The Admin class provides a simple administrative login mechanism with hard-coded credentials. It includes functionality to handle login attempts, error messages for incorrect or empty inputs, and navigation to the main login screen and the administrative panel upon successful login.
The method performLogin validates the admin credentials. It returns true if the username is "admin" and the password is "password".

DataHandler.java:
The DataHandler class provides methods to handle user data storage and retrieval from a text file. It writes user data with writeUserData() method in a comma-separated format and reads it back with readUserData() method  into  a list of string arrays for further processing. This class encapsulates file I/O operations and handles potential I/O exceptions, ensuring robust data management for the application.

User.java:
This class facilitates user authentication and access to the application's functionalities based on the user type (Buyer or Seller).

User Interface: Provides options for users to log in as either a Buyer or a Seller.
Main Navigation: Users can navigate back to the main login screen.
Register Button: Redirects users to the registration page.

Login Process
Seller Login: Checks if the entered credentials match a Seller's account from the userdata file by using readUserData() method of DataHandler class. If successful, redirects to the Seller's dashboard.
Buyer Login: Verifies the entered credentials against a Buyer's account from the userdata file by using readUserData() method of DataHandler class. Upon success, redirects to the Buyer's home page.

Seller Package:

Dashboard.java:
The Dashboard class represents the main interface for the seller's dashboard in the application. It provides various functionalities for the seller to manage their account and products. The Dashboard class provides a navigation hub for sellers to manage their products, wallet, messages, and profile, as well as a log-out feature to return to the login screen. Each button on the dashboard leads to a corresponding window, passing the current user's username for context. This class have some methods in the buttons which are invoked when the buttons are pressed by the user and leads to specific usage.

Messages.java:
This class is used to save messages of the user in a file called msg.txt which will be later shown in the Admin’s Inbox. Whenever a user clicks the send button from this class the method is invoked and the message is saved in a file with the username of the specific user.

Profile.java:

The Profile class is responsible for displaying a user's profile information by reading data from the userdata file. It uses the loadUserData() method to read data which is created in the class. It includes  functionality to search for the user by the username in the file and display the retrieved information. Additionally, it handles the transition back to a Dashboard when the "Back" button is pressed. 


Products.java:

This class allows users to add, delete, and view products. The application also enables image uploading for products. All these tasks are performed with various kinds of methods which are created within the class. To trace the product details, this class uses the username of a seller  in the constructor. It leverages file I/O for persistent storage and image handling for product images. Product details are stored in a file called products.dat file so for storing the products, objects of ProductGetSet class are used which implements the Serializable interface. To save the images of the product saveImage() method is used as a helper method. ImageRenderer class is also used to render the images of products and show it in the JTable. After deleting any product details refreshTableData() method is used to refresh the JTable.

Methods:
 	jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt):
Adds a new product if all text fields (p1, p2, p3, p4) are filled.
Reads existing products from products.dat.
Saves the product image to a designated directory.
Creates a new ProductGetSet object and adds it to the productlist.
Writes the updated productlist back to products.dat.
jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt):
Deletes a product based on user input (d1, d2, d3).
Reads existing products from products.dat.
Removes the matching product from the list.
Writes the updated list back to products.dat.
Calls refreshTableData on the viewproductvar if it is set to refresh the product display.
jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt):
Opens a file chooser for the user to select an image.
Reads the selected image and sets it to sim1.
ToggleButton3ActionPerformed(java.awt.event.ActionEvent evt):
Navigates to the ViewProducts frame if the username is found in the user data.
Disposes of the current Products frame.

ProductGetSet.java:
The ProductGetSet class is a serializable Java class used to encapsulate the details of a product within the application. The constructor of the class Initializes a new product with the provided details: username, productId, productName, unitPrice, numberOfUnits, and imagePath. Getters and Setters methods are also created to get the encapsulated field values. This class serves as a data model for product entities in the application. The class implements Serializable to enable its instances to be easily saved to and retrieved from persistent storage, which is crucial for the application's functionality involving reading and writing product data to files.

ImageRenderer.java:
The ImageRenderer class extends the DefaultTableCellRenderer class. This class is designed to render images within a JTable. The primary purpose of the class is to customize the rendering of table cells in a JTable to display images instead of the default text representation.  It customizes the cell rendering process to include reading an image file, scaling it to fit within the cell, and setting it as an icon on a JLabel. This renderer makes the table visually richer and more informative by displaying image data directly in the table cells.
Image Rendering:
Checks if the value (the cell content) is not null.
Converts the value to a string to get the image path.
Reads the image from the file path using ImageIO.read(new File(imagePath)).
Scales the image to fit within the cell (50x100 pixels) using Image.SCALE_SMOOTH for smooth scaling.
Sets the scaled image as an icon on the label using label.setIcon(new ImageIcon(image)).

SellerWallet.java:
The SellerWallet class encapsulates functionality related to managing the seller's balance. It provides methods to load, save, and update balances, as well as to perform operations such as adding balance and handling user interactions through the GUI. The class reads and writes balances to a text file (balances.txt) using BufferedReader and BufferedWriter respectively. This class uses methods named loadBalances(), saveBalances(), addBalance(), getBalance() and updateSellerBalance() to do specific work according to the names of the method. This class has also some fields like, private static String username: Holds the username of the seller, private static ProductGetSet info: Holds information about a product, private Map<String, Double> balances: Represents a mapping of usernames to their corresponding balances.

ViewProducts.java:
The ViewProducts class is responsible for displaying the list of products for a specific seller. It loads the product data from a file and populates a table with the information. The main method initiates the display of the product view for the logged-in user and establishes communication with the Products class. The constructor Initializes the view of products for the given username and initializes the GUI components. The methods private void loadProducts(): Reads and loads product data from a file (products.dat) and populates the table with the data. Method void refreshTableData(): Clears the table data and reloads it to reflect any changes in the product list. The class reads product data from a binary file (products.dat) using FileInputStream and ObjectInputStream.

Buyer Package:

Home.java:

The Home class displays product images and allows users to interact with these products. This class is a part of the Buyer package and integrates with other classes like ProductGetSet from the Seller package and User from the login package.
The class takes a username as a parameter in the constructor to personalize the user experience. Each product image in the home panel is clickable, leading to a detailed product view. Users can search for products by name and view detailed information if found. For loading images loadProductImages() method is used which Reads the product data from products.dat, scales the images, and assigns them to JLabel components. It also maps each JLabel to its corresponding ProductGetSet object for event handling. There is also a helper method used which is getScaledImageIcon(String imagePath, int width, int height) which Scales an image to the specified dimensions and returns it as an ImageIcon.

Cart.java:

The class implements shopping cart functionality. The code is organized into packages Buyer, AdminPanel, and Seller, each presumably containing related classes. The member variables are used to do specific works like , username1: stores the username of the buyer, info: an instance of ProductGetSet, presumably storing information about a product, cartItems: a list to store items added to the cart, productImageLabels: an array of JLabel used to display product images in the GUI. The constructor Initializes the GUI components, loads cart data, and updates the cart view. Specific methods are used like, loadCartData(): Reads cart data from a file.
UpdateCart(): Updates the cart view with product images, names, and prices.
calculateTotalPrice(): Calculates and displays the total price of items in the cart.
addToCart(ProductGetSet product): Adds a product to the cart.
saveCartData(): Saves cart data to a file.
saveImagesToDirectory(): Saves product images to a directory.
removeProduct(ProductGetSet product): Removes a product from the cart.
deleteImageFile(String imagePath): Deletes an image file.
And Event handling methods for removing items from the cart and navigating back to the home screen.
When a buyer clicks the checkout button then object of SellerWallet and AdminWallet class is created and addBalance() method is invoked that adds balance to the seller and admin wallet according to the percentage of the product price.


ProductV.java:

The ProductV class is used for displaying detailed product information to a buyer. It receives the username of the logged-in user and product details as parameters to customize the displayed content. This class is a part of the Buyer package and interacts with the ProductGetSet class from the Seller package. The key features are Product Details Display: It displays the product name, price, image, and other relevant information, User Interaction: Users can add the product to their cart or navigate back to the home screen, Dynamic Content: The class receives product details dynamically and adjusts the display accordingly. The method setProductDetails() Sets the product image, name, and price based on the received ProductGetSet object.


AdminPanel Package:(username: admin , password: password)

AdminPanel.java:

This class represents the main window of the admin panel. It contains buttons for various administrative tasks like managing users, viewing inbox, viewing buyer and seller lists, accessing admin profile, managing wallet, and logging out. Each button is associated with an action listener to handle user interactions.
Functionality:
jButton1ActionPerformed: Opens the admin inbox.
jButton2ActionPerformed: Opens the admin profile.
jButton3ActionPerformed: Opens the buyer list.
jButton4ActionPerformed: Opens the seller list.
jButton5ActionPerformed: Opens the user management panel.
jButton7ActionPerformed: Opens the admin wallet.
jButton8ActionPerformed: Logs out the admin.

AdminInbox.java:

This class uses a JTable to show the messages from sellers which are saved in the msg.txt file. The constructor initializes the GUI components and loads data into the table by invoking the loadData method. This class uses two methods loadData() which loads data from a file (msg.txt) and populates the table with username and message pairs and readDataFromFile() which reads data from the specified file and returns a list of string arrays containing the username and message pairs. Overall It demonstrates file reading, table population, and GUI event handling functionalities.

AdminProfile.java:

This class represents the main window of the admin profile. The UI consists of panels, labels, and a button. Labels are used for displaying admin information such as full name, mobile number, email address, and password. 

AdminWallet.java:

The variable balance represents the current balance of the admin's wallet. The constructor of this class consists of GUI components method and updateBalance() method.There are several methods used to maintain the balance of seller wallet like:
loadBalance(): Reads the balance from a file (adminIncome.txt) and sets it to the balance variable.
saveBalance(): Writes the current balance to the file.
updateBalance(): Updates the display of the balance on the GUI.
addBalance(double amount): Adds the specified amount to the current balance, saves it, and updates the display.
For file handling BufferedReader and BufferedWriter are used to read from and write to a file named adminIncome.txt.


BuyerList.java:

The class BuyerList represents a window that displays a list of buyers. In the constructor GUI components are initialized and loadBuyerData() method is called which loads the data of all buyers into the JTable. The method reads buyer data from a file named userdata.txt and populates the table with the buyer's information. It uses a BufferedReader to read from the file, splits each line of the file into an array of strings, filters the data for buyers and adds their information to the table's model.


SellerList.java:

The class SellerList represents a window that displays a list of sellers. In the constructor GUI components are initialized and loadSellerData() method is called which loads the data of all sellers into the JTable. The method reads seller data from a file named userdata.txt and populates the table with the seller's information. It uses a BufferedReader to read from the file, splits each line of the file into an array of strings, filters the data for sellers and adds their information to the table's model.


ManageUsers.java:

The ManageUsers class represents a window for managing user data, specifically for deleting and searching sellers and buyers. Some ActionPerformed methods are used to do this functionalities like:

Button7ActionPerformed(ActionEvent evt): 

Deletes a buyer by taking the username from the admin interface.
Reads user data from the file "userdata.txt".
Removes the line corresponding to the specified username from the list of user data.
Writes the updated user data back to the file.
Displays appropriate messages to indicate whether the buyer was successfully deleted or not.
jButton9ActionPerformed(ActionEvent evt): 

Deletes a seller by taking the username from the admin interface.

Similar to the method for deleting buyers, but targets sellers instead.
jButton5ActionPerformed(ActionEvent evt): 

Searches for a seller by name.
Reads user data from the file "userdata.txt".
Compare the entered name with the seller names in the data.
Displays the seller's details if found, otherwise displays a message indicating no seller was found.
jButton6ActionPerformed(ActionEvent evt): 

Searches for a buyer by name.
Similar to the method for searching sellers, but targets buyers instead.

Code Snippets
Below are some key code snippets demonstrating the implementation of core features:
User Registration
Product Management


Database Design

The database schema efficiently manages the e-commerce system's data. Key tables include:
Users:
 Stores user information.
Products:
 Stores product details.
Cart:
Temporary storage for user-selected items.


User Interface Design

User Interface Principles
The UI design prioritizes simplicity, intuitiveness, and responsiveness, ensuring a seamless user experience across devices and screen sizes.

UI Components
Navigation Bar:
Access to Home, Products, Cart, and Account.
Product Listings: 
Displays products with images, names, prices, and ratings.
Shopping Cart: 
Shows selected items with options to update quantities or remove items.
Checkout Form: 
Captures shipping and payment details.


Testing and Quality Assurance

Testing Methodologies
Unit Testing:
Ensures individual components function correctly.
Integration Testing:
Validates the interaction between different components.
System Testing:
Tests the complete system to ensure it meets requirements.

Test Cases
User Registration Test
Description:
Verify that a new user can register successfully.
Steps:
  	1. Navigate to the registration page.
 	 2. Enter valid user details.
  	3. Submit the form.
Expected Result:
A user account is created, and a confirmation message is displayed.

Product Addition Test
Description: 
Verify that a seller can add a new product.
Steps:
  	1. Log in as an administrator.
  	2. Navigate to the product management section.
  	3. Enter product details and save. 
 Expected Result:
The new product appears in the listing.



Deployment

Deployment Steps
Set up the server environment.
Deploy the web application archive (WAR) file to the Apache Tomcat server.
Configure the database connection.
Start the server and perform a smoke test to ensure the application runs correctly.

Post-Deployment Activities
Monitor the application for performance and errors.
Regularly update the application with security patches and new features.
Backup the database and application data.


Conclusion

Summary
The HIVE e-commerce system is a comprehensive solution designed for online shopping. It offers a user-friendly interface, secure transaction processing, and robust administrative tools. Its modular architecture ensures scalability and ease of maintenance.

Difficulties Faced

While developing this shopping management system we faced numerous challenges. Most difficult part was to set up the Products class of the Seller package. In the Products class there is a lot of work for file handling. It was difficult to store the product details and images both in dat file. So the details were stored in the dat file and the images were saved separately in another directory. In the ViewProducts class we faced difficulties to display the images into the JTable columns. We created an ImageRenderer class to overcome the difficulty and then displayed images into JTable columns. We were also having difficulties to show product images dynamically to the Home class of buyers. Then we initialized all JLabels to an ArrayList where the images were getting uploaded and displayed the product images dynamically. 

Achievements
Successful implementation of core e-commerce functionalities.
Development of a scalable and maintainable system architecture.
Comprehensive testing to ensure reliability and performance.


Future Enhancements

Enhanced User Experience:
Advanced Search Functionalities can be made to enhance the search capabilities with filters and  predictive text options.

Withdrawal Options: 
Updated balance after withdrawing money from account and integrated additional payment gateways to offer users more payment options, including digital wallets and cryptocurrencies.

Order Management:
Whenever a buyer buys from a particular seller then the seller would be able to track the orders and get notified. Sellers would be able to see pending and completed orders according to the deliveries.

Product Reviews and Ratings:
Enable customers to leave reviews and ratings for products to build trust and assist other customers in making informed decisions.




 

 
 


 

 

 

 
 


 
 
