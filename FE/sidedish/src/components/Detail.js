import React, { useState } from 'react';
import { IoMdClose } from 'react-icons/io';
import { BadgeBox, Mask, CloseButtn } from './styled/Common';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const Detail = props => {
  const propsData = props.data.item;
  const setPrice = parseInt(propsData.salePrice.replace(',', ''));
  const [quantity, setQuantity] = useState(1);
  const [totalPrice, setTotalPrice] = useState(setPrice);
  const closeDetail = e => {
    const target = e.currentTarget;
    return props.onClickHandler(target);
  };
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
    return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
  };

  const settings = {
    customPaging: function (i) {
      return <img src={`${propsData.thumbImages[i]}`} alt={props.data.title} />;
    },
    dots: true,
    dotsClass: 'slick-dots slick-thumb',
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  };
  return (
    <Mask className='mask' disappear={props.disappear}>
      <div className='detail-wrap'>
        <div className='detail-head'>
          <Slider {...settings} className='detail-thumb'>
            {propsData.thumbImages.map((img, index) => (
              <div className='thumb' key={index}>
                <img src={img} alt={props.data.title} />
              </div>
            ))}
          </Slider>
          <div className='detail-info'>
            <div className='badge'>
              {propsData.badges && propsData.badges.map((badge, index) => (
                    <BadgeBox key={index} backgroundColor={badge.color}>
                      {badge.name}
                    </BadgeBox>
                  ))}
            </div>
            <h3 className='title'>{props.data.title}</h3>
            <p className='description'>{propsData.description}</p>
            <div className='table'>
              <div>
                <span>적립금</span>
                <span>{propsData.point}</span>
              </div>
              <div>
                <span>배송정보</span>
                <span>{propsData.deliveryInfo}</span>
              </div>
              <div>
                <span>배송비</span>
                <span>{propsData.deliveryFee}</span>
              </div>
            </div>
            <div className='price'>
              <div className='item-price'>
                {propsData.normalPrice === propsData.salePrice ? '' : <del>{propsData.normalPrice}</del>}
                {propsData.salePrice} 원
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
        <div className='detail-body'>
          <h3>상세정보</h3>
          {propsData.detailSectionImages.map((item, index) => (
            <p key={index}>
              <img src={item} alt={props.data.title} />
            </p>
          ))}
        </div>
      </div>
      <CloseButtn className='btn-close' onClick={closeDetail}>
        <IoMdClose size='50' color='#bfbfbf' />
      </CloseButtn>
    </Mask>
  );
};

export default Detail;
