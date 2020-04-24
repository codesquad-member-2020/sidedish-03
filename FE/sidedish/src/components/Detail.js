import React, { useState } from 'react';
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
  &:active {
    svg {
      fill: #0e8b87;
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
      left: 10px;
    }
    .slick-next {
      right: 10px;
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
  .detail-info {
    display: flex;
    flex-direction: column;
    padding: 5px 10px;
    .title {
      margin-bottom: 10px;
      font-weight: bold;
      font-size: 26px;
      line-height: 1.3;
      letter-spacing: -1px;
    }
    .description {
      margin-bottom: 20px;
      font-weight: 300;
      font-size: 14px;
      color: #888;
    }
    .table {
      > div {
        display: table;
        margin: 10px 0;
        span {
          display: table-cell;
          line-height: 1.3;
          font-weight: 300;
          color: #888;
        }
        span:first-child {
          width: 100px;
          color: #111;
        }
      }
    }
  }
  .price {
    padding: 10px 0;
    text-align: right;
    .item-price {
      font-weight: bold;
      font-size: 18px;
    }
  }
  .quantity {
    padding: 15px 0;
    margin: 15px 0;
    border-top: 1px solid #111;
    border-bottom: 1px solid #111;
    .quantity-box {
      position: relative;
      button,
      input {
        border: 0;
        text-align: center;
      }
      input {
        width: 100%;
        height: 40px;
        font-weight: bold;
        font-size: 24px;
        border: 1px solid #e0e0e0;
        border-radius: 50px;
      }
      button {
        position: absolute;
        top: 50%;
        width: 40px;
        height: 40px;
        margin-top: -22px;
        font-size: 30px;
        line-height: 0;
        background: transparent;
        z-index: 1;
        cursor: pointer;
        &.btn-minus {
          left: 5px;
        }
        &.btn-plus {
          right: 5px;
        }
        &:focus,
        &:hover {
          outline: none;
        }
      }
    }
  }
  .total {
    display: flex;
    justify-content: space-between;
    align-items: center;
    .tit {
      margin-bottom: 0;
    }
    .total-price {
      span {
        margin-right: 2px;
        font-size: 24px;
      }
      font-weight: bold;
      font-size: 18px;
      color: #2ac1bc;
    }
  }
  .tit {
    margin-bottom: 10px;
    font-size: 16px;
    letter-spacing: -1px;
  }
  .btn-wrap {
    margin-top: auto;
    button {
      width: 100%;
      height: 50px;
      font-size: 24px;
      color: #fff;
      border: 0;
      background: #2ac1bc;
    }
  }
`;

const Detail = props => {
  console.log(props.data.item.data);

  const setPrice = parseInt(props.data.item.data.prices[0].replace(',', ''));
  const [quantity, setQuantity] = useState(1);
  const [totalPrice, setTotalPrice] = useState(setPrice);
  const close = e => {
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
      return <img src={`${props.data.item.data.thumb_images[i]}`} alt={props.data.title} />;
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
                <img src={img} alt={props.data.title} />
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
            <div className='price'>
              <div className='item-price'>{props.data.item.data.prices[0]}</div>
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
        <div className='detail-body'></div>
      </div>
      <CloseButtn className='btn-close' onClick={close}>
        <IoMdClose size='50' color='#bfbfbf' />
      </CloseButtn>
    </Mask>
  );
};

export default Detail;
