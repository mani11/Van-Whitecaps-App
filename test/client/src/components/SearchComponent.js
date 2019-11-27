/**
 * React component to search the player data 
 */
import React, { Component } from 'react';
import search from '../search/search';

class SearchComponent extends Component {

  constructor(props) {
    super(props);
  }

  handleChange(e) {
    let searchString = e.target.value;
    let filteredData = search(searchString, this.props.playerData);
    this.props.onSearch(filteredData);

  }
  render() {
    return (
      <div id="App-searchComponent">
        <input onChange={(e) => {
          this.handleChange(e);
        }} id="App-Search" type="text" placeholder="Search player data"></input>
      </div>
    )
  }

}

export default SearchComponent;