import React from 'react';
import { IoMdClose } from 'react-icons/io';
import styled, { keyframes, css } from 'styled-components';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

const fadeIn = keyframes`
  from { 
    opacity: 0;
  }
  to{
    opacity: 1;
  }
`;

const fadeOut = keyframes`
  from { 
    opacity: 1;
  }
  to{
    opacity: 0;
  }
`;

const slideUp = keyframes`
  from{
    transform: translateY(50px);
  }
  to{
    transform: translateY(0px);
  }
`;

const slideDown = keyframes`
  from{
    transform: translateY(0px);
  }
  to{
    transform: translateY(50px);
  }
`;
const CloseButtn = styled.div`
  position: absolute;
  top: 50px;
  right: 50px;
  cursor: pointer;
  animation-duration: 0.35s;
  animation-timing-function: ease-out;
  animation-name: ${fadeIn};
  animation-fill-mode: forwards;
  svg {
    pointer-events: none;
    transition: 0.125s all ease-in;
  }
  &:hover {
    svg {
      fill: #2ac1bc;
      transform: rotate(90deg);
    }
  }
`;
const Mask = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(247, 249, 250, 0.95);
  z-index: 100;
  animation-duration: 0.25s;
  animation-timing-function: ease-out;
  animation-name: ${fadeIn};
  animation-fill-mode: forwards;
  ${props =>
    props.disappear &&
    css`
      animation-name: ${fadeOut};
    `}
  .detail-wrap {
    overflow-y: auto;
    width: 800px;
    height: calc(100% - 100px);
    padding: 20px;
    margin: 50px 0;
    background: #fff;
    animation-duration: 0.25s;
    animation-timing-function: ease-out;
    animation-name: ${slideUp};
    animation-fill-mode: forwards;
    ${props =>
    props.disappear &&
    css`
      animation-name: ${slideDown};
    `}
  }
  .detail-head {
    display: flex;
    > div {
      width: 50%;
    }
  }
  .detail-thumb {
    .thumb {
      img {
        margin: 0 auto;
      }
    }
    .slick-arrow {
      margin-top: -66px;
    }
    .slick-prev {
      left: 0;
    }
    .slick-next {
      right: 0;
    }
    .slick-dots {
      position: relative;
      bottom: 0;
      margin-top: 15px;
      li {
        width: 80px;
        height: 80px;
        img {
          opacity: 0.6;
        }
        &.slick-active {
          outline: 3px solid #2ac1bc;
          img {
            opacity: 1;
          }
        }
      }
    }
  }
`;

const Detail = props => {
  // console.log(props.data.item.data);
  console.log(props.disappear)
  const close = e => {
    const target = e.currentTarget;
    return props.onClickHandler(target);
  };
  const settings = {
    customPaging: function (i) {
      return <img src={`${props.data.item.data.thumb_images[i]}`} />;
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
      <CloseButtn className='btn-close' onClick={close}>
        <IoMdClose size='50' color='#bfbfbf' />
      </CloseButtn>
    </Mask>
  );
};

export default Detail;
