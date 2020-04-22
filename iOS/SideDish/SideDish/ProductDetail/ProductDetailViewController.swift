//
//  ProductDetailViewController.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit
import SnapKit

extension UIImage {
    static var foodImageSize: CGFloat = 400
}

class ProductDetailViewController: UIViewController {
    
    // MARK: - IBOutlets
    @IBOutlet weak var headerView: UIView!
    @IBOutlet weak var detailView: UIView!
    @IBOutlet weak var foodInformationView: UIView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var pointLabel: UILabel!
    @IBOutlet weak var transportFee: UILabel!
    @IBOutlet weak var transportInformation: UILabel!
    @IBOutlet weak var normalPriceLabel: UILabel!
    @IBOutlet weak var salePriceLabel: UILabel!
    @IBOutlet weak var mainScrollViewHeightConstraint: NSLayoutConstraint!
    private var headerScrollView: UIScrollView = {
        let scrollView = UIScrollView()
        scrollView.isPagingEnabled = true
        return scrollView
    }()
    private var headerContentView: UIView!
    
    // MARK: - Properties
    static var identifier: String = "ProductDetailViewController"
    let headerImages: [String] = [
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
        configureHeaderView()
        configureDetailView()
    }
    
    private func configureHeaderView() {
        headerContentView = UIView()
        headerView.addSubview(headerScrollView)
        headerScrollView.addSubview(headerContentView)
        headerScrollView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
        headerContentView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
            make.height.equalToSuperview()
            make.width.equalToSuperview().multipliedBy(CGFloat(headerImages.count))
        }
        configureImageViews(headerContentView,
                            axis: true,
                            data: headerImages,
                            contentMode: .scaleToFill)
    }
    
    private func configureDetailView() {
        mainScrollViewHeightConstraint.constant =
            UIImage.foodImageSize * CGFloat(detailFoodImages.count - 1) + foodInformationView.frame.height + headerView.frame.height
        configureImageViews(detailView,
                            axis: false,
                            data: detailFoodImages,
                            contentMode: .scaleAspectFit)
    }
    
    // 뷰에서 처리하는게 맞는지 궁금합니다.
    private func generatePosition(_ number: Int, _ axis: Bool) -> CGFloat {
        return axis ?
            view.frame.width * CGFloat(number) : UIImage.foodImageSize * CGFloat(number)
    }
    
    private func configureImageViews(_ view: UIView, axis: Bool, data: [String], contentMode: UIView.ContentMode) {
        let width = self.view.frame.width
        for index in 0 ..< data.count {
            let imageView = UIImageView()
            imageView.image = UIImage(named: data[index])
            imageView.contentMode = contentMode
            let position = generatePosition(index, axis)
            imageView.frame = axis ?
                CGRect(x: position,
                       y: 0,
                       width: width,
                       height: self.view.frame.height * 0.4)
                : CGRect(x: 0,
                         y: position,
                         width: width,
                         height: UIImage.foodImageSize)
            view.addSubview(imageView)
        }
    }
}
