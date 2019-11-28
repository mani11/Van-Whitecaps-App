/**
 * 
 * @param {*} key Search text 
 * @param {*} playerData Player data displayed in the table
 * 
 * Function for text based search on table data
 */
const applySearch = (key, playerData) => {

  return playerData.filter((player) => {
    const { number, name, nationality, position, height, weight, dob, birthplace } = player;
    key = key.toLowerCase();
    if (name.toLowerCase().includes(key) ||
      nationality.toLowerCase().includes(key) ||
      position.toLowerCase().includes(key) ||
      dob.toLowerCase().includes(key) ||
      birthplace.toLowerCase().includes(key) ||
      weight.toString().includes(key) ||
      height.toString().includes(key) ||
      number.toString().includes(key)
    ) {
      return true;
    }
    return false;
  })
}

export default applySearch;