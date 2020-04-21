import React from 'react';
import { createGlobalStyle } from 'styled-components';
import Header from './components/Headers/Header';
import Main from './components/Main';
import Footer from './components/Footer';

const GlobalStyle = createGlobalStyle`
  #wrap {
    overflow: hidden;
    background: #fff;
  }
  .inner {
    width: ${(props) => props.width};
    margin: 0 auto;
  }
`;

function App() {
  return (
    <>
      <GlobalStyle width='1000px' />
      <Header />
      <Main />
      <Footer />
    </>
  );
}

export default App;
