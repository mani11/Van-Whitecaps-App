# Van-Whitecaps-App
This is an app to display the Vancouver Whitecaps MLS team data. It allows for searching and sorting the data.
The Application is build in React.

The following features are included on the client side.


1.  Read data from the /data.json file from inside public directory.

2.  Display the data in the form of a table. The table shows all of the columns from the dataset
    The table supports sorting. Sorting matches the data type of the column - some are text,
    some numeric and one is a date.
    <b>Sorting is done by clicking on the table column heading</b>
    
3. There is a simple text search, where the table is filtered down to the rows that contain the entered string in any field.
   This iscase-insensitive and matches the filter string anywhere in the data
  (e.g. If I enter "aNC" it should match "Vancouver"). this is implemented on the client.
  
4. A summary/aggregation of player nationalities is shown between the search box
  and the table. This shows the different countries the currently visible
  players are from, along with a count (e.g. if two players are from USA and one
  from Brazil, "USA: 2 BRA: 1" will be displayed)
  The summary is up to date with the current search.
  
  ## To start the app :
  1. Clone the app - git clone https://github.com/mani11/Van-Whitecaps-App.git
  2. Inside Van-Whitecaps-App/test/client run npm install to install the node dependencies
  3. Run npm start to start the app
  
  
  
