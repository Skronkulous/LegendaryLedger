# LegendaryLedger
Capstone Project 1: Ledger Application
**************************************
Overview:
-This project is made to be a mock ledger that will allow for
editing of a csv file, and will allow the user to search through
the given info from said csv file.
**************************************
Menus:
-1) Main menu: This will be the main recursive method, as most other
methods and error messages will lead to this main menu.
-2) Ledger Menu: This is the first sub-menu and is used to access some
of the search methods and will lead to the search menu.
-3) Search Menu: This is the menu with the most methods and is the
sub-sub menu. This will allow the user to do more complicated searches.
*************************************
File Manipulation:
-1) CSV Reader: This is the first method that is called in Main
so that all other methods have info to work with. This will read the CSV
given by its respective path, and transfer it into a HashMap that the rest
of the code will use to sort, read, and manipulate.
-2) CSV Writer: This is the final method that is called in Main, as it takes
all of the new additions to the second HashMap and appends it to the
same CSV file as above (1 HashMap for new additions and 1 for the old info
that is transfered from CSV Reader).
-3) Get Name: This is a funny method I just added to see if it would work.
It basically just pulls the file path from the given CSV file and then
extrapolates the local machines name of current User by parsing the path.
************************************
Transaction Object:
-The Transaction object is one of the classes that has its methods called
in almost every other method in the project. This is just storing all of
the info from the CSV file (date, time, description, vendor, amount) into
a single object so our HashMap works efficiently. Also has getters and
setters for each piece of info (getters are used constantly but setters
seem useless unless we add an editing option).
************************************
Payment Methods:
-1) Make Payment: This method is the first of two that add to the new
transactions HashMap (the one that will be appended to the CSV). It 
will add a new Transaction object to that map based off of the given
info the user provides.
-2) Make Deposit: This method is identical to the one above except it returns a 
positive value while the other returns negative.

NOTE: I just realized I could have put these into the same method and
used a public static variable in the menu class where these are called to
so that it would know if the user selected the Payment or Deposit. This may
be a change I implement in the future.
************************************
Display Functionality:
-1) Show All: As the method name implies, this will show all of the 
Transaction values that are stored in both new HashMap and old HashMap.
(Another reason I separated them into to alongside the reasoning of appending
was so I could easily output the newest values first).
-2) Show Payments/Show Deposits: These (as the method name implies) show all
of the payments/deposits depending on which option the user selects. The only
difference is the sign of the amount it is retrieving (negative or positive).

NOTE: As I was writing this I realized that I could have put them both into the
same HashMap (new and old) and sorted by date when I was outputting. Also compared
the HashMap to the current CSV file to see what needs to be appended based off of
the differences (Not sure if this is easier but it is an option I thought of).
***********************************
Searching Functionality:
-1)Month To Date / Year To Date: These methods will first retrieve the dates from both
HashMaps and compare them to the current date (month to date will grab everything from
the first of the month to current date; similarly with year to date). This works by
parsing the date retrieved by the HashMaps and will compare the date and day/ year and day
(depending on the method chosen).
-2)Previous Month / Previous Year: These methods will parse the date retrieved by both of
the HashMaps and compare them to the current date to find the previous month and previous
year respectively. Previous month/year is defined by current month/year -1, so there is a special
case at the beginning for January ( 1 - 1 != 12).
-3) Vendor Search: This method will look at all of the HashMaps in order to find the users
given vendor. It will loop through both and compare the given vendor to the found vendor.
-4) Custom Search: This is the most complicated, but most proud i am of, piece of code here.
  -It all starts with the 'beginning' and 'end' dates at the top (lines 141 & 142). These
  will be used in the first two questions (asking for start and end date of search). Since the
  null values that the user inputs are being taken (just not searched with), initializing these
  date variables at the beginning is very useful if they do not enter anything. These first two
  questions will add all of the matching Transactions into an ArrayList for manipulation further on.
    -Ex: If they put nothing, the loop will add ALL of the Transactions into the ArrayList. If the add
    only the end/beginning, then our pre-initialized values will be filled in for the missing one and
    still complete the range.
-From here on out, it is much easier. The following questions will not have to loop through the HashMaps
anymore, as the Transactions that have met the first requirements are already in the ArrayList. That
being said, instead of adding anymore, we can simply remove the Transactions from the ArrayList that
do not meet the requirements given. It will then print out the final Transactions that are in the
ArrayList.

NOTE: This was much much more confusing when I first wrote it until I added the beginning and
end dates that are initialized at the start.
********************************
Additional Notes:
-All of these methods are completely recursive (unless I missed something), so ignore the little bit
of bloat at the bottom of the methods, it makes it seem bigger than it really is.
-Also, I enjoy using Try Catch satements instead of throwing IOException so you can have
custom error messages. In the mind of the user, they know nothing about this program other than
the fact that it should work. However when an error does pop up, they should be able to recognize
why it showed up in the first place. Even though it is just us using these programs, I still
feel it is a good habit to get into.
