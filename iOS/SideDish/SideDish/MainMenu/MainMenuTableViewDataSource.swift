//
//  MainMenuTableViewDataSource.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

class MainMenuTableViewDataSource: NSObject {
    
}

extension MainMenuTableViewDataSource: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 5
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell =
            tableView.dequeueReusableCell(withIdentifier: MainMenuTableViewCell.identifier,
                                          for: indexPath) as? MainMenuTableViewCell else {
                                            return UITableViewCell()
        }
        cell.updatePrice(normal: "6,500", sale: "5,400원")
        return cell
    }
}
