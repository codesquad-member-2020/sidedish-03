import React from 'react';
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';
import axios from 'axios';
import useAsync from '../../utils/useAsync';
import { URL } from '../../constant/url';
import { Loading } from '../styled/Common';
import Item from '../Item';

export default props => {
  const getData = async () => {
    const response = await axios(`${URL}${props.url}`);
    return response;
  };
  const state = useAsync(getData);

  const { loading, data: bestItems, error } = state;
  if (loading) return <Loading />;
  if (error) return <div>에러</div>;
  if (!bestItems) return null;

  
  return (
    <>
      {bestItems && (
        <Tabs>
          <TabList>
            {bestItems.data.map((cate, index) => (
              <Tab key={index}>{cate.categoryName}</Tab>
            ))}
          </TabList>
          {bestItems.data.map((itemList, index) => (
            <TabPanel key={index}>
              {itemList.items.map((item, i) => <Item key={i} data={item}/>)}
            </TabPanel>
          ))}
        </Tabs>
      )}
    </>
  );
};
