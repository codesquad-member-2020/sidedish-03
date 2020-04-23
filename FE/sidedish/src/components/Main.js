import React from 'react';
import styled from 'styled-components';
import Carousel from "./Carousel";

const MainStyled = styled.div`
  min-height: 600px;
`;

const Main = () => {
  return (
    <MainStyled>
      <div className='inner'>
        <Carousel url="main"/>
      </div>
    </MainStyled>
  );
};

export default Main;
