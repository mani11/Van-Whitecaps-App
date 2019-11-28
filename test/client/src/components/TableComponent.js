import React, { Component } from 'react';
import { sortPlayerData } from '../sorter/sortPlayers';

class TableComponent extends Component {

  sortTableData(e) {
    const colName = e.target.innerText;
    let sortedData = sortPlayerData(colName, this.props.playerData);
    this.props.sortData(sortedData);
  }

  renderTableData() {
    if (this.props.playerData.length > 0) {
      return this.props.playerData.map((player) => {
        const { number, name, nationality, position, height, weight, dob, birthplace } = player;
        return (
          <tr key={number}>
            <td>{number}</td>
            <td>{name}</td>
            <td>{nationality}</td>
            <td>{position}</td>
            <td>{height}</td>
            <td>{weight}</td>
            <td>{dob}</td>
            <td>{birthplace}</td>
          </tr>
        )

      })
    }
  }

  renderTableHeader() {
    if (this.props.playerData.length > 0) {
      const tableHead = Object.keys(this.props.playerData[0]);
      return tableHead.map(heading => {
          return (
            <th key={heading} onClick={(e) => { this.sortTableData(e) }}>{heading.toUpperCase()}</th>
          )
      })
    }
  }
  render() {
    return (
      <table id="App-table">
        <thead>
          <tr>
            {this.renderTableHeader()}
          </tr>
        </thead>
        <tbody>
          {this.props.error ? <tr><td colSpan="8"><i>No matching results</i></td></tr> : this.renderTableData()}
        </tbody>
      </table>
    )

  }

}

export default TableComponent;