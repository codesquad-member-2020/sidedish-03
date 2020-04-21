import React from 'react';
import styled from 'styled-components';
import TopNav from './TopNav';
import GlobalNav from './GlobalNav';

const Header = () => {
  return (
    <div className='header-wrap'>
      <TopNav />
      <div className='inner'>
        <h1 classNmae='logo'>
          <img src='/images/logo.png' />
        </h1>
      </div>
      <GlobalNav />
    </div>
  );
};

export default Header;
