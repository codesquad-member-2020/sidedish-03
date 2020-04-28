import React from 'react';
import styled from 'styled-components';
import TopNav from './TopNav';
import GlobalNav from './GlobalNav';

const HeaderInnderStyled = styled.div`
  padding: 15px 0;
`;

const Header = () => {
  return (
    <div className='header-wrap'>
      <TopNav />
      <HeaderInnderStyled className='inner'>
        <h1 className='logo'>
          <img src={process.env.PUBLIC_URL + '/images/logo.png'} alt='Project Logo' />
        </h1>
      </HeaderInnderStyled>
      <GlobalNav />
    </div>
  );
};

export default Header;
