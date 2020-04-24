import React from 'react';
import styled from 'styled-components';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const Mask = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #f7f9fa;
  z-index: 100;
  .detail-wrap {
    overflow-y: auto;
    width: 800px;
    height: 100%;
    background: #fff;
  }
`;

const Detail = props => {
  console.log(props.data.item.data);
  const settings = {
    customPaging: function(i) {
      return (
        <a>
          <img src={`${props.data.item.data.thumb_images[i]}`} />
        </a>
      );
    },
    dots: true,
    dotsClass: "slick-dots slick-thumb",
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1
  }
  return (
    <Mask className='mask'>
      <div className='detail-wrap'>
        <div className='detail-head'>
          <Slider {...settings} className='detail-thumb'>
            {props.data.item.data.thumb_images.map((img, index) => (
              <div className='thumb' key={index}>
                <img src={img} />
              </div>
            ))}
          </Slider>
          <div className='detail-info'>
            <div className='badge'></div>
            <h3 className='title'>{props.data.title}</h3>
            <p className='description'>{props.data.item.data.product_description}</p>
            <div className='table'>
              <div>
                <span>적립금</span>
                <span>{props.data.item.data.point}</span>
              </div>
              <div>
                <span>배송정보</span>
                <span>{props.data.item.data.delivery_info}</span>
              </div>
              <div>
                <span>배송비</span>
                <span>{props.data.item.data.delivery_fee}</span>
              </div>
            </div>
            <div className='quantity'></div>
            <div className='total'></div>
            <div className='btn'></div>
          </div>
        </div>
        <div className='detail-body'></div>
      </div>
    </Mask>
  );
};

export default Detail;
