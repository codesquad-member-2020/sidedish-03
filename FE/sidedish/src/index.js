import React from 'react';
import ReactDOM from 'react-dom';
import './style/common.scss';
import App from './App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
    <App />,
  document.getElementById('wrap')
);
serviceWorker.unregister();
