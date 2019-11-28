/*
React component that displays the player data group together by nationality
*/
import React from 'react';
import { aggregatePlayersByNationality } from '../aggregates/nationalityAggregation';

const AggregatedComponent = (props) => {

  let aggregatedDataToDisplay = [];
  const aggregatedData = aggregatePlayersByNationality(props.displayData);
    aggregatedDataToDisplay = Array.from(aggregatedData).map(([nationality, noOfPlayers]) => {
      return (
        <div key={nationality} className="App-aggregatedComponent-div">
          <p className="App-aggregatedComponent-p">{nationality} : {noOfPlayers}</p>
        </div>
      )
    })
  return (
    <div className="App-aggregatedComponent-container">
      {props.error ? "" : aggregatedDataToDisplay}
    </div>
  )

}

export default AggregatedComponent;