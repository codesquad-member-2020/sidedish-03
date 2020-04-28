import React from 'react';

const Body = (props) => {
  return (
    <div className='detail-body'>
      <h3>상세정보</h3>
      {props.detaileImages.map((item, index) => (
        <p key={index}>
          <img src={item} alt={props.imgAlt} />
        </p>
    </div>
  );
};

export default Body;
