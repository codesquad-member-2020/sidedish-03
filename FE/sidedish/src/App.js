import React, { useState } from 'react';
import { GlobalStyle, Mainloading } from './components/styled/Common';
import Header from './components/Headers/Header';
import Main from './components/Main';
import Footer from './components/Footer';

function App() {
  const [mainLoading, setMainloading] = useState(true);
  const [visible, setVisible] = useState(false)
  setTimeout(() => {
    setVisible(true);
  }, 1200);
  setTimeout(() => {
    setMainloading(false);
  }, 2000);

  return (
    <>
      <GlobalStyle width='1000px' />
      {mainLoading ? <Mainloading disappear={visible}></Mainloading> : ''}
      <Header />
      <Main />
      <Footer />
    </>
  );
}

export default App;
