import React from 'react';
import Slider from 'react-slick';
import axios from 'axios';
import useAsync from '../utils/useAsync';
import { URL } from '../constant/url';
import { BadgeBox, Loading } from './styled/Common';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import '../style/carousel.scss';

const Carousel = props => {
  const onClickTargetID = async e => {
    e.preventDefault();
    const target = e.currentTarget;
    const targetID = target.dataset.item;
    const targetTitle = target.querySelector('.item-title').innerHTML;
    const response = await axios.get(`${URL}dish/${targetID}`);
    return props.onClickHandler(response.data, targetTitle);
  };

  const getItem = async () => {
    const response = await axios.get(`${URL}${props.url}`);
    return response.data;
  };
  const state = useAsync(getItem);
  const { loading, data: mainItem, error } = state;
  if (loading) return <Loading />;
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
        <span>{mainItem.name}</span>
        {mainItem.description}
      </p>
      <Slider {...settings}>
        {mainItem.dishes.map((item, index) => (
          <div className='item' key={index} data-item={item.id} onClick={onClickTargetID}>
            <div className='item-thumb'>
              <img src={item.mainImage} alt={item.alt} />
              <div className='hover-text'>
                {item.deliveryTypes.map((subMenu, index) => (
                  <p key={index}>{subMenu}</p>
                ))}
              </div>
            </div>
            <div className='item-info'>
              <div className='item-title'>{item.title}</div>
              <div className='item-description'>{item.description}</div>
              <div className='item-price'>
                {item.normalPrice === item.salePrice ? (
                  ''
                ) : (
                  <span className='price-del'>
                    <del>{item.normalPrice}</del>
                  </span>
                )}
                <span className='price-sale'>
                  {item.salePrice}
                  <span className='price-unit'>원</span>
                </span>
              </div>
              <div className='item-badge'>
                {!item.badges
                  ? ''
                  : item.badges.map((badge, index) => (
                      <BadgeBox key={index} backgroundColor={badge.color}>
                        {badge.name}
                      </BadgeBox>
                    ))}
              </div>
            </div>
          </div>
        ))}
      </Slider>
    </div>
  );
};

export default Carousel;
