import React from 'react';
import axios from 'axios';
import { BadgeBox } from './styled/Common';

const Item = props => {
  // const onClickTargetID = async e => {
  //   e.preventDefault();
  //   const target = e.currentTarget;
  //   const targetID = target.dataset.item;
  //   const targetTitle = target.querySelector('.item-title').innerHTML;
  //   const response = await axios.get(`${URL}dish/${targetID}`);
  //   return propsDataonClickHandler(response.data, targetTitle);
  // };
  console.log(props);
  const propsData = props.data;
  return (
    <div className='item' data-item={propsData.id}>
      <div className='item-thumb'>
        <img src={propsData.mainImage} alt={propsData.alt} />
        <div className='hover-text'>
          {propsData.deliveryTypes.map((subMenu, index) => (
            <p key={index}>{subMenu}</p>
          ))}
        </div>
      </div>

      <div className='item-info'>
        <div className='item-title'>{propsData.title}</div>
        <div className='item-description'>{propsData.description}</div>
        <div className='item-price'>
          {propsData.normalPrice === propsData.salePrice ? (
            ''
          ) : (
            <span className='price-del'>
              <del>{propsData.normalPrice}</del>
            </span>
          )}
          <span className='price-sale'>
            {propsData.salePrice}
            <span className='price-unit'>원</span>
          </span>
        </div>
        <div className='item-badge'>
          {propsData.badges &&
            propsData.badges.map((badge, index) => (
              <BadgeBox key={index} backgroundColor={badge.color}>
                {badge.name}
              </BadgeBox>
            ))}
        </div>
      </div>
    </div>
  );
};

export default Item;
