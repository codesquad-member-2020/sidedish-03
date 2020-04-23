import React from 'react';
import Slider from 'react-slick';
import axios from 'axios';
import useAsync from '../utils/useAsync';
import { URL } from '../constant/url';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import '../style/carousel.scss';

const onClickTargetID = async e => {
  e.preventDefault();
  const target = e.currentTarget;
  const targetID = target.dataset.item;

  const response = await axios.get(`${URL}detail/${targetID}`);
  console.log(response.data);
  return response.data;
};

const Carousel = props => {
  const getItem = async () => {
    const response = await axios.get(`${URL}${props.url}`);
    return response.data;
  };
  const state = useAsync(getItem);
  const { loading, data: mainItem, error } = state;
  if (loading) return <div>로딩중</div>;
  if (error) return <div>에러</div>;
  if (!mainItem) return null;

  const settings = {
    dots: false,
    infinite: true,
    speed: 800,
    slidesToShow: 4,
    slidesToScroll: 4,
  };
  return (
    <div className='main-list'>
      <p className='main-list-title'>
        <span>리스트 타이틀</span>리스트 관련 설명이 나올 예정입니다.
      </p>
      <Slider {...settings}>
        {mainItem.body.map((item, index) => (
          <div className='item' key={index} data-item={item.detail_hash} onClick={onClickTargetID}>
            <div className='item-thumb'>
              <img src={item.image} alt={item.alt} />
              <div className='hover-text'>
                {item.delivery_type.map((subMenu, index) => (
                  <p key={index}>{subMenu}</p>
                ))}
              </div>
            </div>
            <div className='item-info'>
              <div className='item-title'>{item.title}</div>
              <div className='item-description'>{item.description}</div>
              <div className='item-price'>
                {!item.n_price ? (
                  ''
                ) : (
                  <span className='price-del'>
                    <del>{item.n_price}</del>
                  </span>
                )}
                <span className='price-sale'>
                  {item.s_price}
                  <span className='price-unit'>원</span>
                </span>
              </div>
              <div className='item-badge'>{!item.badge ? '' : item.badge.map((badge, index) => <span key={index}>{badge}</span>)}</div>
            </div>
          </div>
        ))}
      </Slider>
    </div>
  );
};

export default Carousel;
