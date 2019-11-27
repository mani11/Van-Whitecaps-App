/**
 * 
 * @param {*} colName Column to sort 
 * @param {*} playerData array of player data
 */
export const sortPlayerData = (colName, playerData) => {

  return playerData.sort((a, b) => {
    switch (colName) {
      case 'NUMBER':
        return a.number - b.number;
      case 'NAME':
        return a.name > b.name ? 1 : -1;
      case 'NATIONALITY':
        return a.nationality > b.nationality ? 1 : -1;
      case 'POSITION':
        return a.position > b.position ? 1 : -1;
      case 'HEIGHT':
        return a.height - b.height;
      case 'WEIGHT':
        return a.weight - b.weight;
      case 'DOB':
        let firstDate = new Date(a.dob);
        let secondDate = new Date(b.dob);
        return firstDate > secondDate ? 1 : -1;
      case 'BIRTHPLACE':
        return a.birthplace > b.birthplace ? 1 : -1;
      default:
        return playerData
    }
  });

}







