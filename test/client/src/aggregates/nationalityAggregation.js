/**
 * 
 * @param {*} playerData - Array of Players
 * This function groups the player data present in the table by nationality
 */
export const aggregatePlayersByNationality = (playerData) => {
  
  const initialValue = new Map();
  if (playerData.length > 0) {
    return playerData.reduce((aggregatedData, currentPlayer) => {
      const key = currentPlayer['nationality'];
      const playersForEachNationality = aggregatedData.get(key) + 1 || 1;
      aggregatedData.set(key, playersForEachNationality);
      return aggregatedData;
    }, initialValue);
  }
  else
    return initialValue;

}

