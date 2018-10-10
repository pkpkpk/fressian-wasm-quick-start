const {ipcRenderer} = require('electron')

ipcRenderer.send('ready', '');

ipcRenderer.on('devtools-ready', (event, arg) => {
  require('../target/node/dev/dev-main.js')
});