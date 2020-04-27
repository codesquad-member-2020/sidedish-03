//
//  ProductDetailViewController.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit
import SnapKit

final class ProductDetailViewController: UIViewController {
    
    // MARK: - IBOutlets
    @IBOutlet weak var thumbnailStackView: UIStackView!
    @IBOutlet weak var detailStackView: UIStackView!
    @IBOutlet weak var itemView: UIView!
    @IBOutlet weak var foodInformationView: UIView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var pointLabel: UILabel!
    @IBOutlet weak var transportFee: UILabel!
    @IBOutlet weak var transportInformation: UILabel!
    @IBOutlet weak var priceView: PriceView!
    @IBOutlet weak var mainScrollViewHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var thumbnailScrollViewWidthConstraint: NSLayoutConstraint!
    
    // MARK: - Properties
    static var identifier: String = "ProductDetailViewController"
    private var foodImageSize: CGFloat = 400
    private var mainScrollViewHeight: CGFloat {
        thumbnailStackView.frame.height + itemView.frame.height + (foodImageSize * CGFloat(detailFoodImages.count))
    }
    private var thumbnailScrollViewWidth: CGFloat {
        view.frame.width * CGFloat(thumbnailImages.count)
    }
    let thumbnailImages: [String] = [
        "header",
        "header",
        "header",
    ]
    let detailFoodImages: [String] = [
        "food1",
        "food1",
        "food1",
    ]
    
    // MARK: - Lifecycles
    override func viewDidLoad() {
        super.viewDidLoad()
        configure()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        navigationController?.navigationBar.isHidden = true
    }
    
    // MARK: - Methods
    private func configure() {
        updateScrollViewConstraints()
        configureStackView(thumbnailStackView, data: thumbnailImages)
        configureStackView(detailStackView, data: detailFoodImages)
        priceView.updatePrice(normal: "6,500", sale: "5,600원")
    }
    
    private func updateScrollViewConstraints() {
        thumbnailScrollViewWidthConstraint.constant = thumbnailScrollViewWidth
        mainScrollViewHeightConstraint.constant = mainScrollViewHeight
    }
    
    private func configureStackView(_ view: UIStackView, data: [String]) {
        for i in 0 ..< data.count {
            view.addArrangedSubview(configureImage(image: data[i],
                                                   mode: .scaleToFill))
        }
    }
    
    private func configureImage(image: String, mode contentMode: UIView.ContentMode) -> UIImageView {
        let imageView = UIImageView()
        imageView.image = UIImage(named: image)
        imageView.backgroundColor = .darkGray
        imageView.contentMode = contentMode
        return imageView
    }
}
