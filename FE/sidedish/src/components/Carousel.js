import React from 'react';
import Slider from 'react-slick';
import axios from 'axios';
import useAsync from '../utils/useAsync';
import { URL } from '../constant/url';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import '../style/carousel.scss';

const Carousel = (props) => {
  const getItem = async () => {
    const response = await axios.get(`${URL}${props.url}`);
    return response.data;
  };
  const state = useAsync(getItem);
  const { loading, data: mainItem, error } = state;
  if (loading) return <div>로딩중</div>;
  if (error) return <div>에러</div>;
  if (!mainItem) return null;

  console.log(mainItem.body)

  const settings = {
    dots: false,
    infinite: true,
    speed: 800,
    slidesToShow: 4,
    slidesToScroll: 4,
  };
  return (
    <Slider {...settings}>
      <div className='item' data-item='HBDEF'>
        <div className='item-thumb'>
          <img src='http://public.codesquad.kr/jk/storeapp/data/2d3f99a9a35601f4e98837bc4d39b2c8.jpg' alt='[미노리키친] 규동 250g' />
          <div className='hover-text'>
            <p>새벽배송</p>
            <p>전국택배</p>
          </div>
        </div>
        <div className='item-info'>
          <div className='item-title'>[미노리키친] 규동 250g </div>
          <div className='item-description'>일본인의 소울푸드! 한국인도 좋아하는 소고기덮밥</div>
          <div className='item-price'>
            <span className='price-del'>
              <del>5,000</del>
            </span>
            <span className='price-sale'>
              7,000<span className='price-unit'>원</span>
            </span>
          </div>
          <div className='item-badge'>
            <span>이벤트특가</span>
          </div>
        </div>
      </div>
      <div className='item' data-item='HBDEF'>
        <div className='item-thumb'>
          <img src='http://public.codesquad.kr/jk/storeapp/data/2d3f99a9a35601f4e98837bc4d39b2c8.jpg' alt='[미노리키친] 규동 250g' />
          <div className='hover-text'>
            <p>새벽배송</p>
            <p>전국택배</p>
          </div>
        </div>
        <div className='item-info'>
          <div className='item-title'>[미노리키친] 규동 250g </div>
          <div className='item-description'>일본인의 소울푸드! 한국인도 좋아하는 소고기덮밥</div>
          <div className='item-price'>
            <span className='price-del'>
              <del>5,000</del>
            </span>
            <span className='price-sale'>
              7,000<span className='price-unit'>원</span>
            </span>
          </div>
          <div className='item-badge'>
            <span>이벤트특가</span>
          </div>
        </div>
      </div>
      <div className='item' data-item='HBDEF'>
        <div className='item-thumb'>
          <img src='http://public.codesquad.kr/jk/storeapp/data/2d3f99a9a35601f4e98837bc4d39b2c8.jpg' alt='[미노리키친] 규동 250g' />
          <div className='hover-text'>
            <p>새벽배송</p>
            <p>전국택배</p>
          </div>
        </div>
        <div className='item-info'>
          <div className='item-title'>[미노리키친] 규동 250g </div>
          <div className='item-description'>일본인의 소울푸드! 한국인도 좋아하는 소고기덮밥</div>
          <div className='item-price'>
            <span className='price-del'>
              <del>5,000</del>
            </span>
            <span className='price-sale'>
              7,000<span className='price-unit'>원</span>
            </span>
          </div>
          <div className='item-badge'>
            <span>이벤트특가</span>
          </div>
        </div>
      </div>
      <div className='item' data-item='HBDEF'>
        <div className='item-thumb'>
          <img src='http://public.codesquad.kr/jk/storeapp/data/2d3f99a9a35601f4e98837bc4d39b2c8.jpg' alt='[미노리키친] 규동 250g' />
          <div className='hover-text'>
            <p>새벽배송</p>
            <p>전국택배</p>
          </div>
        </div>
        <div className='item-info'>
          <div className='item-title'>[미노리키친] 규동 250g </div>
          <div className='item-description'>일본인의 소울푸드! 한국인도 좋아하는 소고기덮밥</div>
          <div className='item-price'>
            <span className='price-del'>
              <del>5,000</del>
            </span>
            <span className='price-sale'>
              7,000<span className='price-unit'>원</span>
            </span>
          </div>
          <div className='item-badge'>
            <span>이벤트특가</span>
          </div>
        </div>
      </div>
      <div className='item' data-item='HBDEF'>
        <div className='item-thumb'>
          <img src='http://public.codesquad.kr/jk/storeapp/data/2d3f99a9a35601f4e98837bc4d39b2c8.jpg' alt='[미노리키친] 규동 250g' />
          <div className='hover-text'>
            <p>새벽배송</p>
            <p>전국택배</p>
          </div>
        </div>
        <div className='item-info'>
          <div className='item-title'>[미노리키친] 규동 250g </div>
          <div className='item-description'>일본인의 소울푸드! 한국인도 좋아하는 소고기덮밥</div>
          <div className='item-price'>
            <span className='price-del'>
              <del>5,000</del>
            </span>
            <span className='price-sale'>
              7,000<span className='price-unit'>원</span>
            </span>
          </div>
          <div className='item-badge'>
            <span>이벤트특가</span>
          </div>
        </div>
      </div>
    </Slider>
  );
};

export default Carousel;
