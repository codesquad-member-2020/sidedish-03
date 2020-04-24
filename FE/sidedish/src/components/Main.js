import React, { useState } from 'react';
import styled from 'styled-components';
import Carousel from './Carousel';
import Detail from './Detail';

const MainStyled = styled.div`
  min-height: 600px;
`;

const Main = () => {
  const [ detail, setDetail] = useState(null);
  const onClickDetailItem = (item,title) => {
    setDetail({item,title});
  };
  return (
    <MainStyled>
      <div className='inner'>
        <Carousel url='main' onClickHandler={onClickDetailItem} />
        <Carousel url='soup' onClickHandler={onClickDetailItem} />
        <Carousel url='side' onClickHandler={onClickDetailItem} />
      </div>
      {!detail ?  '' : <Detail data={detail}/>}
    </MainStyled>
  );
};

export default Main;
