import React, { Component } from 'react';
import TableComponent from './components/TableComponent';
import SearchComponent from './components/SearchComponent';
import './App.css';
import AggregatedComponent from './components/AggregatedComponent';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      players: [],
      filteredData: [],
      error: undefined
    }
  }

  componentDidMount() {
    fetch("./data.json")
      .then(response => {
        return response.json();
      }).then((data) => {
        this.setState(() => {
          return {
            players: data['playersData'],
            filteredData: data['playersData']
          }
        })
      })
  }

  filterTableData(filteredData) {
    if (filteredData.length > 0) {
      this.setState(() => {
        return {
          filteredData: filteredData,
          error: undefined
        }
      })
    }
    else {
      this.setState(() => {
        return {
          error: "No Results found"
        }
      })

    }
  }

  sortedTableData(sortedData) {
    this.setState(() => {
      return {
        filteredData: sortedData
      }
    })
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">AppNeta</h1>
        </header>
        <h3 className="App-component-heading">Vancouver Whitecaps MLS team</h3>
        <SearchComponent onSearch={data => { this.filterTableData(data) }} playerData={this.state.players}></SearchComponent>
        <AggregatedComponent error={this.state.error} displayData={this.state.filteredData}></AggregatedComponent>
        <div className="App-table-div">
          <TableComponent error={this.state.error} sortData={sortedData => { this.sortedTableData(sortedData) }} playerData={this.state.filteredData}></TableComponent>
        </div>
      </div>
    );
  }
}

export default App;
