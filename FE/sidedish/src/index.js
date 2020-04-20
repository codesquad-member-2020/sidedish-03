import React from 'react';
import ReactDOM from 'react-dom';
import './style/common.scss';
import App from './App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('wrap')
);
serviceWorker.unregister();
