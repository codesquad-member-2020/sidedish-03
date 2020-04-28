import React, { useState } from 'react';
import { BadgeBox } from '../styled/Common';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const Head = props => {
  const setPrice = parseInt(props.detailData.salePrice.replace(',', ''));
  const [quantity, setQuantity] = useState(1);
  const [totalPrice, setTotalPrice] = useState(setPrice);

  const onIncrease = () => {
    setQuantity(prevQuantity => prevQuantity + 1);
    return setTotalPrice(setPrice * (quantity + 1));
  };
  const onDecrease = () => {
    if (quantity === 1) return;
    setQuantity(prevQuantity => prevQuantity - 1);
    return setTotalPrice(prevPrice => prevPrice - setPrice);
  };
  const priceCommas = price => {
    const regComma = /\B(?=(\d{3})+(?!\d))/g;
    return price.toString().replace(regComma, ',');
  };

  const settings = {
    customPaging: function (i) {
      return <img src={`${props.detailData.thumbImages[i]}`} alt={props.detailTitle} />;
    },
    dots: true,
    dotsClass: 'slick-dots slick-thumb',
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };
  return (
    <div className='detail-head'>
      <Slider {...settings} className='detail-thumb'>
        {props.detailData.thumbImages.map((img, index) => (
          <div className='thumb' key={index}>
            <img src={img} alt={props.detailTitle} />
          </div>
        ))}
      </Slider>
      <div className='detail-info'>
        <div className='badge'>
          {props.detailData.badges &&
            props.detailData.badges.map((badge, index) => (
              <BadgeBox key={index} backgroundColor={badge.color}>
                {badge.name}
              </BadgeBox>
            ))}
        </div>
        <h3 className='title'>{props.detailTitle}</h3>
        <p className='description'>{props.detailData.description}</p>
        <div className='table'>
          <div>
            <span>적립금</span>
            <span>{props.detailData.point}</span>
          </div>
          <div>
            <span>배송정보</span>
            <span>{props.detailData.deliveryInfo}</span>
          </div>
          <div>
            <span>배송비</span>
            <span>{props.detailData.deliveryFee}</span>
          </div>
        </div>
        <div className='price'>
          <div className='item-price'>
            {props.detailData.normalPrice === props.detailData.salePrice ? '' : <del>{props.detailData.normalPrice}</del>}
            {props.detailData.salePrice} 원
          </div>
        </div>
        <div className='quantity'>
          <p className='tit'>수량 선택</p>
          <div className='quantity-box'>
            <button className='btn-minus' onClick={onIncrease}>
              +
            </button>
            <input type='number' className='inp-qty' value={quantity} readOnly />
            <button className='btn-plus' onClick={onDecrease}>
              -
            </button>
          </div>
        </div>
        <div className='total'>
          <p className='tit'>총 금액</p>
          <div className='total-price'>
            <span>{priceCommas(totalPrice)}</span>원
          </div>
        </div>
        <div className='btn-wrap'>
          <button>담기</button>
        </div>
      </div>
    </div>
  );
};

export default Head;
